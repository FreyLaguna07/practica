import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class loginComponent implements OnInit {

  hide = true;

  constructor(
    private router: Router,
) {
}

  ngOnInit() {
  }
  iniciarSesion(){
     this.router.navigate(['./main/navs']);
  }


}
