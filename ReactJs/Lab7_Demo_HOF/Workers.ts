import { Staff } from "./Staff";


class Workers extends Staff{

    /**
     * Getter rank
     * @return {number}
     */
	public getRank(): number {
		return this.rank;
	}

    /**
     * Setter rank
     * @param {number} value
     */
	public setRank(value: number) {
		this.rank = value;
	}

	constructor(
        name: string,
        age: number,
        gender: string,
        address: string,
        rank: number) {
        super(name , age , gender, address);
        this.rank = rank ;
	}

    private rank: number;

    
    public printInforWorker() {
        console.log("Thông tin worker");
        super.printInforStaff();
        console.log("Rank: ", this.rank);
        }

}

export {Workers};

	

	
