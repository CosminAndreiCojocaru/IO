package flf;


public class FlfHeader {
    private char hardBlank;
    private int height;
    private int commentLines;

    public FlfHeader(char hardBlank, int height, int commentLines) {
        this.hardBlank = hardBlank;
        this.height = height;
        this.commentLines = commentLines;
    }

    public FlfHeader() {

    }

    public char getHardBlank() {
        return hardBlank;
    }

    public void setHardBlank(char hardBlank) {
        this.hardBlank = hardBlank;
    }

    public int getHeight() {
        return height;
    }

    public int getCommentLines() {
        return commentLines;
    }

    public void setCommentLines(int commentLines) {
        this.commentLines = commentLines;
    }

    @Override
    public String toString() {
        return "FlfHeader [hardBlank=" + hardBlank + ", height=" + height
                + ", commentLines=" + commentLines + "]";
    }


}
