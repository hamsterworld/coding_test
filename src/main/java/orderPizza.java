//public class orderPizza {
//
//    private final SimplePizzaFactory simplePizzaFactory;
//
//    Pizza orderPizza(String type) {
//
//        Pizza pizza;
//
//        Pizza pizza = simplePizzaFactory.createPizza("cheese");
//
//        pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();
//
//        return pizza;
//
//    }
//
//    public class SimplePizzaFactory {
//
//        public Pizza createPizza(String type){ //이런 경우에는 static메소드로 선언하는 경우가 종종 있음.
//
//            Pizza pizza = null;
//
//            if(pizza.equals("cheese")) pizza = new CheesePizza();
//            if(pizza.equals("pepper")) pizza = new PepperoniPizza();
//            if(pizza.equals("clam")) pizza = new ClamPizza();
//            if(pizza.equals("veggie")) pizza = new VeggiePizza();
//
//            return pizza;
//
//        }
//
//    }
//
//
//}
//
//PizzaStore nyStore = new PizzaStore(new NYPizzaFactory());
//
//nyStore.orderPizza("cheese");
//
//PizzaStore chicagoStore = new PizzaStore(new ChicagoPizzafactory());
//
//chicagoStore.orderPizza("cheese");
