import { Staff } from "./Staff";

class Workers extends Staff {
        private rank: number ;

	constructor(name: string , age: number, gender: string ,address: string, rank: number) {
        super(name , age , gender , address);
        this.rank = rank;
	}

    /**
     * Getter rank
     * @return {number }
     */
	public getRank(): number  {
		return this.rank;
	}

    /**
     * Setter rank
     * @param {number } value
     */
	public setRank(value: number ) {
		this.rank = value;
	}
    public printIn4Woker() {
        console.log("Thông tin Worker");
        super.printIn4Staff();
        console.log(" Rank: " + this.rank);
    }

}

export {Workers}