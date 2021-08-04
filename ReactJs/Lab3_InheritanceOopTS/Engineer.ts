import { Staff } from "./Staff";

class Engineer extends Staff {
    private specializad: string ;
    
    constructor(name: string , age: number, gender: string ,address: string, specializad: string) {
        super(name , age , gender , address);
        this.specializad = specializad;
	}

    /**
     * Getter specializad
     * @return {string }
     */
	public getSpecializad(): string  {
		return this.specializad;
	}

    /**
     * Setter specializad
     * @param {string } value
     */
	public setSpecializad(value: string ) {
		this.specializad = value;
	}

    public printIn4Engineer() {
        console.log("Thông tin của kỹ sư là: ");
        super.printIn4Staff();
        console.log("Specializad: " + this.setSpecializad);
    };
}


export {Engineer}