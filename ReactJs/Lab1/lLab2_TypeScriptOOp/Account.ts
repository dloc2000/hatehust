import {Department} from "./Department";
import {Position} from "./Position";

class Account {
    

    /**
     * Getterid
     * 
     */
	public getid(): number {
		return this.id;
	}

    /**
     * Getteremail
     * 
     */
	public getemail(): string {
		return this.email;
	}

    /**
     * Getterusername
     * 
     */
	public getusername(): string {
		return this.username;
	}

    /**
     * Getterfullname
     
     */
	public getfullname(): string {
		return this.fullname;
	}

    /**
     * Getterdepartment
     * }
     */
	public getdepartment(): Department {
		return this.department;
	}

    /**
     * Getterposition
     * 
     */
	public getposition(): Position {
		return this.position;
	}

    /**
     * GettercreateDate
     * 
     */
	public getcreateDate(): Date {
		return this.createDate;
	}

    /**
     * Setterid
     * 
     */
	public setid(value: number) {
		this.id = value;
	}

    /**
     * Setteremail
     * 
     */
	public setemail(value: string) {
		this.email = value;
	}

    /**
     * Setterusername
     * 
     */
	public setusername(value: string) {
		this.username = value;
	}

    /**
     * Setterfullname
     * 
     */
	public setfullname(value: string) {
		this.fullname = value;
	}

    /**
     * Setterdepartment
     *
     */
	public setdepartment(value: Department) {
		this.department = value;
	}

    /**
     * Setterposition
     * 
     */
	public setposition(value: Position) {
		this.position = value;
	}

    /**
     * SettercreateDate
     * 
     */
	public setcreateDate(value: Date) {
		this.createDate = value;
	}
  private id: number;
  private email: string;
  private username: string;
  private fullname: string;
  private department: Department;
  private position: Position;
  private createDate: Date;


	constructor(id: number,
         email: string,
         username: string,
         fullname: string,
         department: Department,
         position: Position,
         createDate: Date) {
             this.id = id; 
             this.email = email;
             this.username = username;
             this.fullname = fullname;
             this.department = department;
             this.position = position;
             this.createDate = createDate;
	}

}

function printIn4Account(account: Account){
    console.log("Id: " + account.getid()
                + "email: " + account.getemail()
                + "username: " + account.getusername()
                + "fullname: " + account.getfullname()
                + "department: " + account.getdepartment().getName
                + "position: " + account.getposition().getname
                + "createDate: "+ account.getcreateDate()
    )
}

export{Account , printIn4Account}