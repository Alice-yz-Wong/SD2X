package Implementing and Improving Software;

public class MyFunGame {
    public int clock=0;
    protected List<Player> players = new LinkedList<Player>();
    public void addPlayer(String name){
        players.add(new Player(name));
    }
    public void go(){
        clock++;
        for(Player p:players){
            if(p.isAlive()&& p.points()>0){
                if(p.ready()){
                    p.move();
                }else{
                    p.pause();
                }
            }
        }
    }
}
