import { Department } from "./Department";

class Position {

    /**
     * Getterid
     * 
     */
	public getid(): number  {
		return this.id;
	}

    /**
     * Gettername
     *
     */
	public getname(): string {
		return this.name;
	}

    /**
     * Setterid
     * 
     */
	public setid(value: number ) {
		this.id = value;
	}

    /**
     * Settername
     * 
     */
	public setname(value: string) {
		this.name = value;
	}
    private id: number ;
    private name: string;

    constructor(id: number, name: string){
        this.id =id;
        this.name= name;
    }

   

}
function printIn4Position(position: Position){
    console.log("Id: " + position.getid + "Name: " + position.getname)
}
let dep1 = new Position(1 , "trang oc cho");
printIn4Position(dep1);
export {Position, printIn4Position};