import { Staff } from "./Staff";

class Employee extends Staff {
    private task: string ;
    
    constructor(name: string , age: number, gender: string ,address: string, task: string) {
        super(name , age , gender , address);
        this.task = task;
	}


    /**
     * Getter task
     * @return {string }
     */
	public getTask(): string  {
		return this.task;
	}

    /**
     * Setter task
     * @param {string } value
     */
	public setTask(value: string ) {
		this.task = value;
	}

    public printIn4Employee() {
        console.log("Thông tin của nhân viên là: ");
        super.printIn4Staff();
        console.log("task: " + this.task);
    }
}

export {Employee}