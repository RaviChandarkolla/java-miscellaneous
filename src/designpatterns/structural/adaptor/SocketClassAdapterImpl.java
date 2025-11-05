package designpatterns.structural.adaptor;

// The adapter design pattern is one of the structural design patterns and is used so that two unrelated interfaces
// can work together. The object that joins these unrelated interfaces is called an adapter.

// Class Adapter - This form uses java inheritance and extends the source interface, in our case Socket class.

//Using inheritance for adapter pattern
public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v, 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }

}
