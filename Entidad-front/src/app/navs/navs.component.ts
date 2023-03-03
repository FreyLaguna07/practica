import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navs',
  templateUrl: './navs.component.html',
  styleUrls: ['./navs.component.scss']
})
export class NavsComponent {
      showMenu = false;
      hidden = false;


  constructor(
    private breakpointObserver: BreakpointObserver,
    private router: Router
    ) {}
    ngOnInit() {
    }

  cerrarSesion(){
    sessionStorage.clear();
    this.router.navigate(['./']);
  }

  VerNotificacion(){
    this.hidden = true;
  }
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
 toggleMenu() {
  this.showMenu = !this.showMenu;
}
}
