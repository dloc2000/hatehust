import { Staff } from "./Staff";

class Engineer extends Staff {
  private specialized: string;
  
  constructor(
    name: string,
    age: number,
    gender: string,
    address,
    specialized: string
  ) {
    super(name, age, gender, address);
    this.specialized = specialized;
  }
  /**
     * Getter specialized
     * @return {string}
     */
	public getSpecialized(): string {
		return this.specialized;
	}

    /**
     * Setter specialized 
     * @param {string} value
     */
	public setSpecialized(value: string) {
		this.specialized = value;
	}

    public printInforEngineer() {
        console.log("Thông tin Engineer");
        super.printInforStaff();
        console.log("Sspecialized: " + this.specialized);
        }
       
}

export {Engineer};
