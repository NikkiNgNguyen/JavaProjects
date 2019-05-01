/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NikkiNguyen
 */
public class UnderGrad extends Student{
    UnderGrad(String name, String major, int units){
        super(name, major,units);
    }
        public int calculateTuition(int units){
            return units * 250;
        }
    }
