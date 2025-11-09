package designpatterns.dependecy_injection.service_injector;

import designpatterns.dependecy_injection.consumer.Consumer;

public interface MessageServiceInjector {

    public Consumer getConsumer();
}
