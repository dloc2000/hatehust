class Account {
  private id: number;
  private email: string;
  private username: string;
  private fullname: string;

	constructor(id: number, email: string, username: string, fullname: string) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
	}

    /**
     * Getter id
     * @return {number}
     */
	public getId(): number {
		return this.id;
	}

    /**
     * Getter email
     * @return {string}
     */
	public getEmail(): string {
		return this.email;
	}

    /**
     * Getter username
     * @return {string}
     */
	public getUsername(): string {
		return this.username;
	}

    /**
     * Getter fullname
     * @return {string}
     */
	public getFullname(): string {
		return this.fullname;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public setId(value: number) {
		this.id = value;
	}

    /**
     * Setter email
     * @param {string} value
     */
	public setEmail(value: string) {
		this.email = value;
	}

    /**
     * Setter username
     * @param {string} value
     */
	public setUsername(value: string) {
		this.username = value;
	}

    /**
     * Setter fullname
     * @param {string} value
     */
	public setFullname(value: string) {
		this.fullname = value;
	}

}
 
// C1
function printInforStaff(account: Account): void{
    console.log("id:  " + account.getId() + "Name: " + account.getEmail()
     + "Username: " + account.getUsername() + "fullName: " + account.getFullname())
};

// C2
let printAccount = function prin_other(account: Account): void {
    console.log("id:  " + account.getId() + "Name: " + account.getEmail()
    + "Username: " + account.getUsername() + "fullName: " + account.getFullname())
}

// C3 Arrow Function
let print_Account_ArrowFunction = (account: Account) => {
    console.log("id:  " + account.getId() + "Name: " + account.getEmail()
    + "Username: " + account.getUsername() + "fullName: " + account.getFullname())
}

//C4 viết thu gọn Arrow Function
let print_Account_ArrowFunction1= account =>
console.log("id:  " + account.getId() + "Name: " + account.getEmail()
+ "Username: " + account.getUsername() + "fullName: " + account.getFullname())
export {Account , printInforStaff , printAccount , print_Account_ArrowFunction ,print_Account_ArrowFunction1};
