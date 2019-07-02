import { Service} from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDTO} from '../dto/userdto';

export abstract class AbstractService<DTO>  implements Service <DTO> {

  type: string;
  port: string;
  nome: string;

  constructor(protected http: HttpClient) {

  }

  getAllBy(id: number): Observable<DTO[]> {
    return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.nome + '/' + this.type + id, {
      headers: {
        Authorization : this.auth()
      }
    });
  }
  getAll(): Observable<DTO[]> {
    return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.nome + '/' + 'api' + '/' + this.type , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  read(id: number): Observable<DTO> {
    return this.http.get<DTO>('http://localhost:' + this.port + '/' + this.nome + '/' + 'api' + '/'  + this.type + id , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  delete(id: number): Observable<any> {
    return this.http.delete('http://localhost:' + this.port + '/' + this.nome + '/' + 'api' + '/' + this.type + id , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  insert(dto: DTO): Observable<DTO> {
    return this.http.post<DTO>('http://localhost:' + this.port + '/' + this.nome + '/' + 'api' + '/' + this.type, dto , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  update(dto: DTO): Observable<DTO> {
    return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.nome + '/' + 'api' + '/' + this.type, dto , {
      headers: {
        Authorization : this.auth()
      }
    });

  }

  auth() {
    const user = JSON.parse(localStorage.getItem('Autoken')) as UserDTO;
    if (user) {
      console.log('Bearer ' + user.authorities);
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }

  }

}