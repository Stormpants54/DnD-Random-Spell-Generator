public class Spells {
    private String name, castTime, duration, description, type, components, range;
    private int level;

    public Spells(String name, String type, int level, String castTime, String range, String components, String duration,String description){
        this.castTime = castTime;
        this.components = components;
        this.type = type;
        this.level = level;
        this.duration = duration;
        this.range = range;
        this.name = name;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    private String splitList(String list){
        String[] descriptList = list.split("\\.");
        String empty = "\n";
        for(int i = 0; i < descriptList.length;i++){
            if(i == descriptList.length - 1){
                empty += removeBeginningSpaces( descriptList[i]);
            }
            else{
                empty += removeBeginningSpaces( descriptList[i]) + ".\n";
            }
        }
        return empty;
    }

    private String removeBeginningSpaces(String removeSpace){
        String hi = removeSpace;
        for(int i = 0 ; i < 3 ; i ++){
            if(removeSpace.substring(i, i + 1).matches(" ")){
                removeSpace = removeSpace.substring(i+1);
            }
        }
        return  removeSpace;
    }


    @Override
    public String toString(){
        String sentence = "Spell: "+ name + "\n";
        if(level == 0){
            sentence += type +" cantrip\n";
        } else if (level == 1) {
            sentence += level + "st-level " + type + "\n";

        }
        else if (level == 2) {
            sentence += level + "nd-level " + type + "\n";

        }
        else if (level == 3) {
            sentence += level + "rd-level " + type + "\n";

        } else {
            sentence += level+ "th-level " + type +"\n";
        }
        sentence +=castTime + "\n" +
                "Range: " + range + "\n"+
                components + "\n" +
                duration + "\n" +
                "Description: " + description;
        return sentence;
    }

    public String toStringWrite(){
        String sentence = name + "\n";
        if(level == 0){
            sentence += type +" Cantrip\n";
        } else if (level == 1) {
            sentence += level + "st-level " + type + "\n";

        }
        else if (level == 2) {
            sentence += level + "nd-level " + type + "\n";

        }
        else if (level == 3) {
            sentence += level + "rd-level " + type + "\n";

        } else {
            sentence += level+ "th-level " + type +"\n";
        }
        sentence +=castTime + "\n" +
        "Range: " + range + "\n"+
        components + "\n" +
        duration  +
        splitList(description);
        return sentence;
    }

}
