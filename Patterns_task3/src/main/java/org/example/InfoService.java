package org.example;
interface InfoService { void showInfo(Student s); }

class RealInfoService implements InfoService {
    public void showInfo(Student s) {
        System.out.println(s.toString());
    }
}

class ProxyInfoService implements InfoService {
    private RealInfoService real = new RealInfoService();
    public void showInfo(Student s) {
        System.out.println("Логирование доступа к " + s.getName());
        real.showInfo(s);
    }
}

class HeadmanDecorator implements InfoService {
    private InfoService wrapper;
    public HeadmanDecorator(InfoService source) { this.wrapper = source; }
    public void showInfo(Student s) {
        System.out.print("Status: HEADMAN | ");
        wrapper.showInfo(s);
    }
}