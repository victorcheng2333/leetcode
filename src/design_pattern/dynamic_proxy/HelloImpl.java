package design_pattern.dynamic_proxy;

class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello word");
    }
}
