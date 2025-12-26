package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Silver3_2606_바이러스 {

    /*
    접근 방법
    1. HashSet<Computer>, 감염 여부 상태를 가진 computer 클래스를 정의한다.
    2. 받은 입력으로 컴퓨터 간 연결 관계를 만든다. Computer.neighbors
    3. 1번 컴퓨터부터 시작하여 연결된 컴퓨터를 재귀호출하며 감염시킨다.
     */
    
    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 상태 정보를 가지는 computer 클래스
    3. 입력 받은 네트워크로 컴퓨터를 연결하는 addNeighbors 메서드
    4. 감염되었는지 검증하고 감염시키는 infection 메서드
     */

    // 새로 감염되는 컴퓨터의 수
    static int count = 0;


    static class Computer {

        Set<Computer> neighbors; // 연결된 컴퓨터들 (중복을 허용하지 않는 HashSet으로 객체 생성)
        boolean isInfected = false; // 감염 여부

        Computer(boolean isInfected) {
            this.neighbors = new HashSet<>();
            this.isInfected = isInfected;
        }
    }

    /**
     * 이미 연결되어 있는지 검증하고 연결되어 있지않다면 연결하는 메서드
     */
    static void addNeighbors(Computer computerA, Computer computerB) {
        // 중복 추가를 방지하기 위해 이미 추가되어 있다면 return
        if(!computerA.neighbors.contains(computerB)) {
            computerA.neighbors.add(computerB);
            computerB.neighbors.add(computerA);
        }
    }

    
    /**
     * 감염 메서드
     */
    static void infection(Computer computer) {

        // 현재 컴퓨터가 건강한 상태면 감염 및 count 증가
        if(!computer.isInfected) {
            computer.isInfected = true;
            count++;
        }

        // 연결된 컴퓨터를 순환하며 infection() 재귀호출
        computer.neighbors.forEach((nextComputer) -> {
            
            // 다음 컴퓨터가 감염된 상태일 경우 이미 방문했으므로 스킵한다.
            if(!nextComputer.isInfected) {
                infection(nextComputer);
            }
        });
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerNum = Integer.parseInt(br.readLine());
        int networkNum = Integer.parseInt(br.readLine());

        Computer[] computers = new Computer[computerNum];
        for (int i = 0; i < computerNum; i++) {
            computers[i] = new Computer(false);
        }
        computers[0].isInfected = true; // 1번 컴퓨터는 감염 상태

        for (int i = 0; i < networkNum; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            addNeighbors(computers[a-1], computers[b-1]);
        }

        // 루트 컴퓨터부터 infection() 호출
        infection(computers[0]);

        System.out.println(count);
    }
}
