import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  base=environment.url
constructor(
  private http: HttpClient
) { }
  insertEntidad(id_tipo_documento: number, nro_documento: string, razon_social: string, nombre_comercial: string,
    id_tipo_contribuyente: number, direccion: string, telefono: string) {
    return this.http.post(this.base + 'entidadv1/insert-entidad?id_tipo_documento=' + id_tipo_documento + '&nro_documento=' + nro_documento + '&razon_social=' + razon_social
      + '&nombre_comercial=' + nombre_comercial + '&id_tipo_contribuyente=' + id_tipo_contribuyente + '&direccion=' + direccion + '&telefono=' + telefono, []);
  }
  updateEntidad(idEntidad: number, id_tipo_documento: number, nro_documento: string, razon_social: string, nombre_comercial: string,
    id_tipo_contribuyente: number, direccion: string, telefono: string) {
    return this.http.put(this.base + 'entidadv1/update-entidad?id=' + idEntidad+ '&id_tipo_documento='+id_tipo_documento + '&nro_documento=' + nro_documento + '&razon_social=' + razon_social
      + '&nombre_comercial=' + nombre_comercial + '&id_tipo_contribuyente=' + id_tipo_contribuyente + '&direccion=' + direccion + '&telefono=' + telefono, []);
  }
  listTipoDocument(){
    return this.http.get(this.base + 'tipo-documentov1/get-tipo-docuento' );
  }
  listTipoContribuyente(){
    return this.http.get(this.base + 'tipo-contribuyentev1/get-tipo-contribuyente' );
  }
  listEntidad(){
    return this.http.get(this.base + 'entidadv1/get-entidad' );
  }
  deleteContribuyente(id:number){
    return this.http.delete(this.base + 'entidadv1/delete-entidad?idEntidad='+id);
  }
}
