package flf;

import java.util.ArrayList;
import java.util.List;

public class StringBlock {
    private List<String> lines;

    public StringBlock(List<String> lines) {
        this.lines = lines;
    }
    public StringBlock concat(StringBlock sbExcl){
        List<String> line1 = this.getLines();
        List<String> line2 = sbExcl.getLines();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < line1.size(); ++i){
            result.add(line1.get(i) + line2.get(i));
        }

        return new StringBlock(result);
    }

    public List<String> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        String result = "";
        for (String line : lines) {
            result += line;
            result += "\n";
            System.out.println(line);
        }

            return result;





    }





}
