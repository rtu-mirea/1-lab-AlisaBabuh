package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Second {
    StringBuilder text;
    HashSet<String> keys;
    Second(){
        this.text = new StringBuilder();
        this.keys = new HashSet<String>();
    }
    Second(StringBuilder text, HashSet<String> keys){
        this.text = text;
        this.keys = keys;
    }

    public void setKeys(HashSet<String> keys) {
        this.keys = keys;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }
//Сформировать строку из пользовательских идентификаторов левой части оператора присваивания.
    public StringBuilder identificator(){
        if(text.length() == 0){
            System.out.println("Инициализация не произведена"); return null;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return null;
        }
        StringBuilder ans = new StringBuilder();
        int pos = text.indexOf("=");
        while(pos != -1){
            int spacePos = pos - 2;
            while(spacePos >= 0 && text.charAt(spacePos) != ' ')
                spacePos--;
            if(!keys.contains(text.substring(spacePos+1, pos-1)))
                ans.append(text.substring(spacePos+1, pos-1) + " ");
            pos = text.indexOf("=", pos+1);
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.print("Идентификаторы: ");
        System.out.println(ans);
        return ans;
    }
//Преобразовать строку: оставить только ключевые слова языка, которые используются в тексте.
    public StringBuilder delIndent(){
        if(text.length() == 0){
            System.out.println("Инициализация не произведена"); return null;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена"); return null;
        }
        StringBuilder ans = new StringBuilder();
        int pos = text.indexOf(" ");
        while(pos != -1){
            int spacePos = pos - 1;
            while(spacePos >= 0 && text.charAt(spacePos) != ' ')
                spacePos--;
            String word = text.substring(spacePos+1, pos);
            if(!keys.contains(word))
                ans.append(text.substring(spacePos+1, pos) + " ");
            pos = text.indexOf(" ", pos+1);
        }
        if (ans.length() > 0)
            ans.deleteCharAt(ans.length()-1);
        text = ans;
        System.out.print("Текст без идентификаторов: ");
        System.out.println(text);
        return text;
    }
//Вставить новое ключевое слово, которого нет в строке, перед первым словом.
    public StringBuilder insertNew(){
        if(text.length() == 0){
            System.out.println("Инициализация не произведена."); return null;
        }
        if(keys.size() == 0){
            System.out.println("Инициализация не произведена."); return null;
        }
        HashSet<String> unused = (HashSet<String>)keys.clone();
        int pos = text.indexOf(" ");
        while(pos != -1){
            int spacePos = pos - 1;
            while(spacePos >= 0 && text.charAt(spacePos) != ' ')
                spacePos--;
            String word = text.substring(spacePos+1, pos);
            if(unused.contains(word))
                unused.remove(word);
            pos = text.indexOf(" ", pos+1);
        }
        if (unused.size() > 0){
            text.insert(0, unused.iterator().next());
        }
        System.out.print("Изменённый текст: ");
        System.out.println(text);
        return text;
    }
}
