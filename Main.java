import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int answer = 0;
        int temp = 0;
        Scanner scanner = new Scanner(System.in);

        for (int a = 0; ; a++) {
            System.out.println("대중교통을 입력하세요\n1.버스\n2.택시");

            switch (scanner.nextInt()) {
                case 1: {
                    Bus bus = new Bus();
                    for (int i = 0; ; i++) {
                        System.out.println("선택하세요\n1.운행변경\n2.속도변경\n3.요금\n4.승객탑승\n5.오일변경\n6.상단페이지로");
                        if (temp == 1) {
                            temp = 0;
                            break;
                        }
                        switch (scanner.nextInt()) {

                            case 1: {
                                bus.changeState();
                                break;
                            }
                            case 2: {
                                System.out.println("변경할 속도로 입력하세요");

                                bus.changeVelocity(scanner.nextInt());
                                break;
                            }
                            case 3: {
                                System.out.println("요금");
                                bus.calTax();
                                break;
                            }
                            case 4: {
                                System.out.println("탑승할 승객 수 입력하세요. 현재승객" + bus.passengerNum);
                                bus.passengerRide(scanner.nextInt());
                                break;
                            }
                            case 5: {
                                System.out.println("+추가(감소)할 오일값 입력");
                                bus.oilChange(scanner.nextInt());
                                break;
                            }
                            case 6: {
                                temp = 1;
                                break;
                            }

                        }
                    }
                    break;
                }

                case 2: {
                    Taxi taxi = new Taxi();
                    for (int i = 0; ; i++) {
                        System.out.println("선택하세요\n1.운행변경\n2.속도변경\n3.목적지변경\n4.승객탑승(운행시작)\n5.오일변경\n6.상단페이지로");
                        if (temp == 1) {
                            temp = 0;
                            break;
                        }
                        switch (scanner.nextInt()) {

                            case 1: {
                                taxi.changeState();
                                break;
                            }
                            case 2: {
                                System.out.println("변경할 속도로 입력하세요");

                               taxi.changeVelocity(scanner.nextInt());
                                break;
                            }
                            case 3: {
                                System.out.println("변경할 목적지 입력하세요");
                                taxi.changeDestination(scanner.next());
                                System.out.println("목적지와의 거리를 입력하세요");
                                taxi.changeDistance(scanner.nextInt());
                                System.out.println("목적지:"+taxi.destination+", 거리:"+taxi.distanceToDestination);
                                break;
                            }
                            case 4: {
                                System.out.println("현재상태:"+taxi.state);
                                if(taxi.state.equals("탑승중")){
                                    System.out.println("탑승이 불가능합니다! 운행변경을 해주세요");
                                    break;}
                                else{
                                System.out.println("탑승할 승객 수 입력하세요. 현재승객:" + taxi.passengerNum);
                                taxi.passengerRide(scanner.nextInt());
                                taxi.changeState();
                                    System.out.println("현재목적지:"+taxi.destination);
                                    System.out.println("목적지를 입력하세요");
                                    taxi.changeDestination(scanner.next());
                                    System.out.println("목적지와의 거리를 입력하세요");
                                    taxi.changeDistance(scanner.nextInt());
                                    System.out.println("요금 정산입니다");
                                    taxi.calTax();

                                break;}
                            }
                            case 5: {
                                System.out.println("+추가(감소)할 오일값 입력");
                                taxi.oilChange(scanner.nextInt());
                                break;
                            }
                            case 6: {
                                temp = 1;
                                break;
                            }

                        }
                    }
                    break;
                }
            }
        }
    }
}

class PublicTransportation {
    int transportNumber = 1234;

    int oilMount = 100;
    int nowVelocity = 0;
    int maxPassenger = 100;
    int tax = 0;

    String onState= "운행중";
    String noState= "차고지행";
    String state = onState;
    int passengerNum = 0;

    //여기서 부터 메소드 입니다
    void changeVelocity(int velocity) {
        nowVelocity = velocity;
        System.out.println("현재속도:" + nowVelocity);
        return;
    }
    void changeStateNo(){
        state= noState;
    }
    void changeState() {
        if (state.equals(onState)) {
            state = noState;
            System.out.println(state);
            System.out.println("오일량"+oilMount);
        } else {
            state = onState;
            System.out.println(state);
            System.out.println("오일량"+oilMount);
        }

    }

    void passengerRide(int pasNum) {

        if (state.equals("noState")) {
            System.out.println("운행중이 아닙니다");
            return;
        }
        if(oilMount<10){
            System.out.println("오일량이 적어 운행이 불가합니다");
            return;
        }
        if ((passengerNum + pasNum > maxPassenger)) {
            System.out.println("승객 초과");
        } else {
            passengerNum += pasNum;

            System.out.println("탑승후승객수" + passengerNum);
            System.out.println("잔여승객수" + (maxPassenger - passengerNum));
           // changeState();
        }
    }

    void oilChange(int oil) {
        oilMount += oil;
        if (oilMount < 10) {
            System.out.println();
            System.out.print("주유량 확인요망");
           // changeStateNo();
        }
        System.out.println("주유량:"+oilMount);
    }
}

class Bus extends PublicTransportation {
    int transportNumber = 4758;

    public Bus() {
        this.maxPassenger = 30;
    }

    int defaulttax = 1000;


    //여기부터 메소드 입니다
    void calTax() {
        tax = passengerNum * defaulttax;
        System.out.println(tax);
    }

    // int nowPassenger;

}

class Taxi extends PublicTransportation {
    String destination = "없음";
    int distanceToDestination = 0;
    int defaultDistance = 1;
    int defaultTax = 3000;
    int taxOfDistance = 1000;
    public Taxi() {
        this.maxPassenger = 4;
        this.state ="일반";
        this.onState ="일반";
        this.noState="탑승중";
    }
    //여기부터 메소드 입니다.

    void calTax() {
        this.tax = (taxOfDistance * (distanceToDestination - defaultDistance)) + defaultTax;
        System.out.println("기본요금:" + defaultTax+",최종요금:"+tax);
    }


    void changeDestination(String s) {
        destination = s;
        System.out.println("목적지는:"+s);
    }

    void changeDistance(int distan) {
        distanceToDestination = distan;
    }
}

