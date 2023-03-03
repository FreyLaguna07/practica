import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { loginComponent } from './Base/login/login.component';
import { MantenedorEntidadComponent } from './content/mantenedorEntidad/mantenedorEntidad.component';
import { NavsComponent } from './navs/navs.component';
const routes: Routes = [
  {
    path: '',
    component: loginComponent,
  },
  {
  path: 'main',
  component: NavsComponent,

  children: [
    {
      path: 'navs',
      loadChildren: () =>
        import('./navs/navs.module').then((m) => m.NavsModule)
    },
        {
          path: 'navs/mantenedorEntidad',
          component: MantenedorEntidadComponent
        },


    //{path: '**', redirectTo: 'login'}

  ],
  },
  {path: '**', redirectTo: '', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, relativeLinkResolution: 'legacy'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
