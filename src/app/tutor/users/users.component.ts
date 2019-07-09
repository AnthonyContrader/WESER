import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();
  userx : UserDTO;
  constructor(private service: UserService) { }

  ngOnInit() {
    this.getUsers();
  }
  getUsers() {
    this.service.getAll().subscribe( (data:any)  => 
      {
        console.log(data);
      this.users = data;
      
      this.userx = data[0];
      console.log("this.userx");
      });
    
  }

  delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUsers());
  }

  deleteU(user: UserDTO) {
    this.service.deleteU(user.login).subscribe(() => this.getUsers());
  }
  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUsers());
  }

  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUsers());
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }
}
