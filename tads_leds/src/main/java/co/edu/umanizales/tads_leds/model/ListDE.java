package co.edu.umanizales.tads_leds.model;

import lombok.Data;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Data
public class ListDE {
    private NodeDE head;
    private int size;

    public void addToStart(Led led){
        if(head !=null){
            NodeDE newNodeDE = new NodeDE(led);
            newNodeDE.setNext(head);
            head.setPrevious(newNodeDE);
            head = newNodeDE;
        }
        else {
            head = new NodeDE(led);
        }
        size++;

    }

    public void addToEnd(Led led){
        if(head != null){
            NodeDE temp = head;
            while (temp.getNext() != null) {
                temp= temp.getNext();
            }
            // temp es el último nodo de la lista
            NodeDE newNodeDE = new NodeDE(led);
            temp.setNext(newNodeDE);
            newNodeDE.setPrevious(temp);
        } else {
            head = new NodeDE(led);
        }
        size++;
    }

    /*
    Reiniciar leds
    si hay datos
        ayudante se para en cabeza
        mientras temp se diferente de null{
            si hay leds prendidos led == true{
                lo apago led==false
       }
       se pasa
       }
     */
    public void getRestartLed (){
        if(head != null){
            NodeDE temp = head;
            while (temp != null){
                Led led = temp.getData();
                if(led.isState() == true){
                    led.setState(false);
                }
                temp = temp.getNext();
            }
        }
    }

    /*
    Prender extremos
    si hay datos
    si
    dividir el tamano de la lista en 2 para obtener la mitad de la lista
     Si es par, es decir su residuo siempre va a ser 0
        si esto se cumple se crearian 2 ayudantes uno que se ubique en la cebeza y otro tambien
         darles la instruccion que avace un tempral hasta la mitad y el otro temporal se vaya hasta la mitad mas 1
         luego darles la instruccion al mismo tiempo que el primer ayudante retroceda y el segudno ayudante adelante
         que al pasar el primer led se prenda por 1 segundo y se apague y actualizar al mismo tiempo la hora y se pase al otro led y haglo mismo
         luego al llegar los dos ayudantes al final dejar prendidos los dos extremos
         y me salgo
   Si es impar
       si esto se cumple se crearian 2 ayudantes uno que se ubique en la cebeza y otro tambien en cabeza
       darles la instruccion que avace un tempral hasta la mitad y el otro temporal se vaya hasta la mitad mas 2
       luego darles la instruccion al mismo tiempo que el primer ayudante retroceda y el segudno ayudante adelante
         que al pasar el primer led se prenda por 1 segundo y se apague y actualizar al mismo tiempo la hora y se pase al otro led y haglo mismo
         luego al llegar los dos ayudantes al final dejar prendidos los dos extremos
         y me salgo
   no
   no hay datos para ejecutar el metodo
     */

    public void getTurnOnLedBy1SecondAndTurnOnExtremes() throws InterruptedException {
        int middle = size / 2;
        NodeDE temp = head;
        NodeDE temp2;
        if (head != null) {
            // Si es par, avanzar hasta la mitad
            if (middle % 2 == 0) {
                int i=1;
                while ( i < middle) {
                    temp = temp.getNext();
                    i++;
                }
                temp2 = temp.getNext();// avanzo uno

                temp.getData().setState(true);
                temp.getData().setDateOn(LocalTime.now());
                temp2.getData().setState(true);
                temp2.getData().setDateOn(LocalTime.now());
                TimeUnit.SECONDS.sleep(1);
                temp.getData().setState(false);
                temp.getData().setDateOff(LocalTime.now());
                temp2.getData().setState(false);
                temp2.getData().setDateOff(LocalTime.now());

                NodeDE prev = temp.getPrevious();
                NodeDE next = temp2.getNext();
                while (prev.getPrevious() != null && next.getNext() != null) {
                    prev.getData().setState(true);
                    prev.getData().setDateOn(LocalTime.now());
                    next.getData().setState(true);
                    next.getData().setDateOn(LocalTime.now());
                    TimeUnit.SECONDS.sleep(1);
                    prev.getData().setState(false);
                    prev.getData().setDateOff(LocalTime.now());
                    next.getData().setState(false);
                    next.getData().setDateOff(LocalTime.now());
                    prev = prev.getPrevious(); // Avanzar hacia el LED anterior
                    next = next.getNext();
                }
                prev.getData().setState(true);
                next.getData().setState(true);
                prev.getData().setDateOn(LocalTime.now());
                next.getData().setDateOn(LocalTime.now());

            }
            // Si es impar, avanzar hasta la mitad
            else {
                int i=1;
                while (i < middle) {
                    temp = temp.getNext();
                    i++;
                }
                temp2 = temp.getNext().getNext();// avanzo dos

                temp.getData().setState(true);
                temp.getData().setDateOn(LocalTime.now());
                temp2.getData().setState(true);
                temp2.getData().setDateOn(LocalTime.now());
                TimeUnit.SECONDS.sleep(1);
                temp.getData().setState(false);
                temp.getData().setDateOff(LocalTime.now());
                temp2.getData().setState(false);
                temp2.getData().setDateOff(LocalTime.now());

                NodeDE prev = temp.getPrevious();
                NodeDE next = temp2.getNext();
                while (prev.getPrevious() != null && next.getNext() != null) {
                    prev.getData().setState(true);
                    prev.getData().setDateOn(LocalTime.now());
                    next.getData().setState(true);
                    next.getData().setDateOn(LocalTime.now());
                    TimeUnit.SECONDS.sleep(1);
                    prev.getData().setState(false);
                    prev.getData().setDateOff(LocalTime.now());
                    next.getData().setState(false);
                    next.getData().setDateOff(LocalTime.now());
                    prev = prev.getPrevious(); // Avanzar hacia el LED anterior
                    next = next.getNext();
                }
                prev.getData().setState(true);
                next.getData().setState(true);
                prev.getData().setDateOn(LocalTime.now());
                next.getData().setDateOn(LocalTime.now());
                prev.getData().setDateOff(null);
                prev.getData().setDateOff(null);
            }
        }
    }
}
