package inbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Silver2_18126_너구리구구 {

    /*
    접근 방법
    1. 방의 정보를 가지는 Room 클래스를 정의한다. Room 클래스는 다음 속성을 가진다.
        - index: 방의 번호
        - nextRooms: 연결된 방 List
        - distanceList: 연결된 방들까지의 거리 List
        - isVisited: 방문 여부
    2. 입력을 받고 각 거리를 계산하여 distance에 넣는다.
    3. 입구부터 마지막 방까지 재귀 호출하며 총 거리를 계산한다.
     */

    /*
    책임 분배
    1. 입력을 받고 결과를 출력하는 main 메서드
    2. 연결된 방과 방문 여부, 다음 방까지의 거리를 가지는 Room 클래스
    3. 마지막 방까지 거리를 탐색하는 search 메서드
     */

    static long totalDistance = 0; // 입구부터 끝 방까지 총 거리
    static Room[] rooms; // 모든 방 배열

    static class Room {
        int index; // 방 번호
        List<Room> nextRooms; // 연결된 방 List
        List<Integer> distanceList; // 연결된 방들까지의 거리 List
        boolean isVisited; // 방문 여부

        Room(int index) {
            this.index = index;
            this.nextRooms = new ArrayList<>();
            this.distanceList = new ArrayList<>();
            this.isVisited = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            rooms[i] = new Room(i);
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 인스턴스 속성값 정의
            // 양쪽 다 정의
            rooms[a - 1].nextRooms.add(rooms[b - 1]);
            rooms[a - 1].distanceList.add(c);
            rooms[b - 1].nextRooms.add(rooms[a - 1]);
            rooms[b - 1].distanceList.add(c);

        }

        // 재귀 호출
        search(0, 0);

        System.out.println(totalDistance);
    }


    /**
     * 방을 탐색하며 totalDistance를 추가하는 메서드
     * @param index           방 번호
     * @param currentDistance 현재까지의 거리
     */
    static void search(int index, long currentDistance) {

        // 방문 처리
        rooms[index].isVisited = true;

        // 현재 거리가 최대값보다 크다면 갱신
        if (totalDistance < currentDistance) {
            totalDistance = currentDistance;
        }

        // 연결된 다음 방이 있다면
        if (!rooms[index].nextRooms.isEmpty()) {

            List<Room> nextRooms = rooms[index].nextRooms; // 연결된 방 목록
            List<Integer> distanceList = rooms[index].distanceList; // 연결된 방들까지의 거리 목록

            for (int i = 0; i < nextRooms.size(); i++) { // 연결된 방의 개수만큼 순환

                Room nextRoom = nextRooms.get(i);

                if (!nextRooms.get(i).isVisited) { // 다음 방을 방문하지 않은 경우에만
                    search(nextRoom.index, currentDistance + distanceList.get(i)); // 다음 방까지의 거리를 더하여 재귀 호출
                }
            }
        }
    }


}