export class Cure {
    id: number;
    
    cf: string;
	
	age: number;
	
	pato: string;
	
	name: string;
	
	quantity: string;
	
    notes: string;


    constructor(id: number, cf: string, age: number, pato: string, name: string, quantity: string, notes:string) {
        this.id = id;
        this.cf = cf;
        this.age = age;
        this.pato = pato;
        this.name = name;
        this.quantity = quantity;
        this.notes = notes;
    }   
}