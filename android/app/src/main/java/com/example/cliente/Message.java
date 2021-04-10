package com.example.cliente;

public class Message {

        //Atributos
        private String accion;

        //Constructores
        public Message(String accion) {
            this.accion = accion;
        }

        public void setAccion(String accion) {
            this.accion = accion;
        }

        public String getAccion() {
            return this.accion;
        }
}
