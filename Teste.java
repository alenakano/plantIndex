class Motos {
  public static int totalMotos = 0;
  
  public static int getTotalMotos() {
    return totalMotos;
  }
  
}

class Teste {
   public static void main(String[] args) {
    Motos.totalMotos = 15;
    System.out.println(Motos.getTotalMotos());
  }
}