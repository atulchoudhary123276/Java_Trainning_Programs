package FunctionalPrograming.Assignment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class Dispatch {
    private String shippingAdd;
    private LocalDateTime dispatchDate;
    private String estDeliveryDate;

    public Dispatch(String shippingAdd){
        this.shippingAdd= shippingAdd;
        this.dispatchDate= LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.estDeliveryDate=dispatchDate.plusDays(5).format(format);
    }
    public String getShippingAdd(){
        return shippingAdd;
    }
    public LocalDateTime getDispatchDate(){
        return dispatchDate;
    }
    public String getEstDeliveryDate(){
        return estDeliveryDate;
    }
}
