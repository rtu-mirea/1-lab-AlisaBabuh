package com.company;

import java.util.ArrayList;
import java.util.List;

public class Map
{
    List<Path> paths = new ArrayList<>();

    public void addPath(String place1, String place2, int time)
    {
        paths.add(new Path(new String[]{place1, place2},time));
    }
    public List<String> getAllPlaces()
    {
        List<String> places = new ArrayList<>();
        for(int i=0;i<paths.size();i++)
        {
            String place1 = paths.get(i).points[0];
            String place2 = paths.get(i).points[1];
            if(!places.contains(place1)){places.add(place1);}
            if(!places.contains(place2)){places.add(place2);}
        }
        return places;
    }
    public void fill()
    {
        paths.add(new Path(new String[]{"1", "2"},1));
        paths.add(new Path(new String[]{"2", "5"},6));
        paths.add(new Path(new String[]{"2", "3"},1));
        paths.add(new Path(new String[]{"1", "3"},3));
        paths.add(new Path(new String[]{"3", "4"},2));
        paths.add(new Path(new String[]{"4", "5"},2));
    }

    int time = 0;
    int min_time =Integer.MAX_VALUE;
    List<String> shortest_way = new ArrayList<>();
    List<String> curr_way = new ArrayList<>();
    public List<String> get_shortest_way(String place1, String place2)
    {
        generateShortWay(place1, place2,0);
        return shortest_way;
    }
    private void fill_shortest(List<String> list)
    {
        shortest_way.clear();
        for(int i=0; i<list.size();i++)
        {
            shortest_way.add(list.get(i));
        }
    }
    public void generateShortWay(String place1, String place2, int last_time)
    {
        curr_way.add(place1);
        for(int i=0;i<paths.size();i++)
        {
            String start_place = paths.get(i).points[0];
            String end_place = paths.get(i).points[1];
            if(paths.get(i).points[0].equals(place1))
            {
                int new_time = paths.get(i).time;
                if(end_place.equals(place2))
                {
                    time += new_time;
                    curr_way.add(end_place);
                    if(time < min_time)
                    {
                        min_time = time;
                        fill_shortest(curr_way);
                    }
                    time -= new_time;
                    curr_way.remove(curr_way.size()-1);
                }
                else
                {
                    time += new_time;
                    if (time >= min_time)
                    {
                        time -= last_time;
                        curr_way.remove(curr_way.size() - 1);
                        return;
                    }
                    generateShortWay(end_place, place2, new_time);
                }
            }

        }
        time -= last_time;
        curr_way.remove(curr_way.size() - 1);
        return;
    }

}
