import { PatologyDTO } from './patologydto';
import { ReadingDTO } from './readingdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @author PattyGè
 */
export class CureDTO {

    id: number;

    readingDTO : ReadingDTO;
	
	age: number;
	
	patologyDTO : PatologyDTO;
	
	name: string;
	
	dosage: string;

	posology: string;
	
    notes: string;
    
}