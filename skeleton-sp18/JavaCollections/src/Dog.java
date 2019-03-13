public interface Dog {
  default int bark(){
    System.out.println("Dog bark!!!");
    return 1;
  }
}
