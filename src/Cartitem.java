public class Cartitem {
    private String itemno;
    private double unitcost;
    private int quantity;
    private double totalcost;
     
    public String getitemno() {
        return itemno;
    }
    public void setitemno(String itemno) {
        this.itemno = itemno;
    }
    public double getunitcost() {
        return unitcost;
    }
    public void unitcost(double unitcost) {
        this.unitcost = unitcost;
    }
    public int getquantity() {
        return quantity;
    }
    public void setquantity(int quantity) {
        this.quantity = quantity;
    }
    public double gettotalcost() {
        return totalcost;
    }
    public void totalcost(double totalcost) {
        this.totalcost = totalcost;
    }
}