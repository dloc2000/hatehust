class Department {
    private id : number ;
    private name: string ;


    constructor(id: number , name: string){
        this.id = id;
        this.name =name;
    }
    // get,set of name
    public getName(): string {
        return this.name;
    }
    public setName(name: string):void{
        this.name = name;
    }
    // get , set of Id
    public getId(): number {
        return this.id;
    }
    public setId(id: number):void{
        this.id = id;
    }
}

// Function ko phu thuoc vao class
function printIn4Department(department: Department){
    console.log("ID: ", department.getId() , "Name: " , department.getName())
}
let dep1 = new Department(1 , "trang oc cho");
printIn4Department(dep1);
export {Department , printIn4Department};