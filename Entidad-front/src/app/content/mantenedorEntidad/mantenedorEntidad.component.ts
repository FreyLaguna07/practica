import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { ServiceService } from 'src/app/Service/service.service';


export interface reportCapacitacion {
  tipoPersona?: string;
  tipoDocumento?: string;
  detDocumento?: string;
  codDocumento?: string;
  nroDocumento?: string;
  rSocial?: string;
  nomComercial?: string;
  direccion?: string;
  telefono?:String;
  idEntidad?: number;
  idTipoDocumento?: number;
  idTipoContribuyente?:number;
}

@Component({
  selector: 'app-mantenedorEntidad',
  templateUrl: './mantenedorEntidad.component.html',
  styleUrls: ['./mantenedorEntidad.component.scss']
})
export class MantenedorEntidadComponent implements OnInit {

  listTipoDocuments:any = [];
  idEntidad:number=0;
  listTipoContribuyentes:any = [];
  formGroupParent: any = [];
  ELEMENT_DATA:reportCapacitacion[] = [];
  displayedColumns: string[] = ['tipoPersona', 'tipoDocumento', 'detDocumento', 'codDocumento' ,'nroDocumento', 'rSocial','nomComercial','direccion','telefono','Actualizar','Eliminar'];

  constructor(
    private service: ServiceService,
    private fb: FormBuilder
  ) {
    this.formGroupParent = this.fb.group({
      tipoPersona: new FormControl("",[Validators.required]),
      tipoDocumento: new FormControl("",[Validators.required]),
      numDocument: new FormControl("",[Validators.required]),
      rSocial: new FormControl("",[Validators.required]),
      nomComercial: new FormControl(""),
      direccion: new FormControl(""),
      telefono: new FormControl(""),
    });
  }

  ngOnInit() {
    this.listTipoDocument();
  }
  listTipoDocument(){
    this.service.listTipoDocument().subscribe(
      (result:any)=>{
        this.listTipoDocuments = result.data;
        this. listTipoContribuyente();
      }
    );
  }
  listTipoContribuyente(){
    this.service.listTipoContribuyente().subscribe(
      (result:any) =>{
        this.listTipoContribuyentes = result.data;
        this.listEntidad();
      }
    );
  }
  listEntidad(){
   this.service.listEntidad().subscribe(
    (result:any)=>{
      result.data.forEach((element:any) => {
        this.ELEMENT_DATA.push(
          { idEntidad:element.id_entidad,
            tipoPersona:element.tipoContribuyente.nombre,
            tipoDocumento:element.tipoDocumento.nombre,
            detDocumento:element.tipoDocumento.descripcion,
            codDocumento:element.tipoDocumento.codigo,
            nroDocumento:element.nro_documento,
            rSocial:element.razon_social,
            nomComercial:element.nombre_comercial,
            direccion:element.direccion,
            telefono:element.telefono,
            idTipoDocumento:element.tipoDocumento.id_tipo_documento,
            idTipoContribuyente:element.tipoContribuyente.id_tipo_contribuyente
          }
        );
      });
    }
   );
  }
  registrarEntidad(){
    this.formGroupParent.markAllAsTouched();
    if(this.formGroupParent.invalid){
      return;
    }
    this.service.insertEntidad(this.formGroupParent.controls.tipoDocumento.value,this.formGroupParent.controls.numDocument.value,this.formGroupParent.controls.rSocial.value,
      this.formGroupParent.controls.nomComercial.value,this.formGroupParent.controls.tipoPersona.value,this.formGroupParent.controls.direccion.value,this.formGroupParent.controls.telefono.value).subscribe(
      (result:any)=>{
        if(result.data==1){
          this.ELEMENT_DATA = [];
          this.listEntidad();
        }
      }
    );
  }

  editarCampos(e:any){
    this.idEntidad= e.idEntidad;
    this.formGroupParent.controls.tipoDocumento.setValue(e.idTipoDocumento);
    this.formGroupParent.controls.numDocument.setValue(e.nroDocumento);
    this.formGroupParent.controls.rSocial.setValue(e.rSocial);
    this.formGroupParent.controls.nomComercial.setValue(e.nomComercial);
    this.formGroupParent.controls.tipoPersona.setValue(e.idTipoContribuyente);
    this.formGroupParent.controls.direccion.setValue(e.direccion);
    this.formGroupParent.controls.telefono.setValue(e.telefono);

  }
  actualizarEntidad(){
    this.formGroupParent.markAllAsTouched();
    if(this.formGroupParent.invalid){
      return;
    }
    this.service.updateEntidad(this.idEntidad,this.formGroupParent.controls.tipoDocumento.value,this.formGroupParent.controls.numDocument.value,this.formGroupParent.controls.rSocial.value,
      this.formGroupParent.controls.nomComercial.value,this.formGroupParent.controls.tipoPersona.value,this.formGroupParent.controls.direccion.value,this.formGroupParent.controls.telefono.value).subscribe(
      (result:any)=>{
        if(result.data==1){
          this.ELEMENT_DATA = [];
          this.listEntidad();
        }
      }
    );
  }
  accion(){
    if(this.idEntidad == 0){
      this.registrarEntidad();
    }else{
      this.actualizarEntidad();
    }
  }
  eliminarEntidad(e:any){
    this.service.deleteContribuyente(e.idEntidad).subscribe(
      (result:any)=>{
        if(result.data == 1){
          this.ELEMENT_DATA = [];
          this.listEntidad();
        }
      }
    );
  }
  keyPress(event: any) {
    const pattern = /[0-9]/;
    let inputChar = String.fromCharCode(event.charCode);
    if (event.keyCode != 8 && !pattern.test(inputChar)) {
      event.preventDefault();
    }
  }
  onlyLetras(event: any) {
    const pattern = /[A-Z ]/;
    let inputChar = String.fromCharCode(event.charCode);
    if (event.keyCode != 8 && !pattern.test(inputChar)) {
      event.preventDefault();
    }
  }
  limpiarFormulario(){
    this.formGroupParent.reset();
  }
}
