import { User } from './User';
import { Children } from './Children';
export class AdoptionRecord {
    parent: User = new User();
    child:Children = new Children();
    adoptionDate: Date;
}