import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../data-access/service/authentication.service";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  mail: string = "";
  password: string = "";

  invalidData: boolean = false;

  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  onLogin() {
    this.authenticationService.login(this.mail, this.password).subscribe(() => this.router.navigateByUrl('/user'), (error) => this.invalidData = true);
  }
}
