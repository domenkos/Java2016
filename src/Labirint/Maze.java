package Labirint;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domen
 */
public class Maze {
    private int width,height;
    boolean[][] walls;
    int[][] rout;
    private int startY,stopY,pointer,length;
    private boolean founded;
    
    // sirina x visina in pozicija starta ter stopa
    // u resnici je visina x sirina
    Maze(int x, int y, int startY, int stopY){
        this.startY = startY;
        this.stopY = stopY;
        this.width = x;
        this.height = y;
        this.pointer = 2;
        this.founded = false;
        this.length = 0;
        this.raise_walls();
    }
    
    Maze(int x, int y){
        this.startY = 1;
        this.stopY = x-2;
        this.width = x;
        this.height = y;
        this.pointer = 2;
        this.founded = false;
        this.length = 0;
        this.raise_walls();
        
    }

    boolean find_the_way(){
        int j = 0, i = this.startY;
        int pomX, pomY;
        int zblj = 0;
        int max_mozne = this.width * this.height / 2 + 1;
        int counter = 0;
        while((!this.founded)&& max_mozne > counter){
            for(int z = 0; z < this.height; z++){
                for(int k = 0; k < this.width; k++){
                    step(j,i);
                    j = z;
                    i = k;
                }
            }
            pointer ++;
            counter++;
            
        }
        if(!this.founded)
            return false;
        this.length = this.pointer - 1;
        return true;
        
    }
    
    void step(int j, int i){
        int pomX, pomY;
        if(this.rout[i][j] == (this.pointer - 1)){
            try{
                pomY = j;
                pomX = i;
                pomX ++;
                if(!this.walls[pomX][pomY]) // ce ni zida
                    if(found(pomX,pomY,pointer))
                        this.founded = true;
                    
            }
            catch(ArrayIndexOutOfBoundsException napaka){

            }
            try{
                pomY = j;
                pomX = i;
                pomX--;
                if(!this.walls[pomX][pomY]) // ce ni zida
                    if(found(pomX,pomY,pointer))
                        this.founded = true;
            }
            catch(ArrayIndexOutOfBoundsException napaka){

            }
            try{
                pomY = j;
                pomX = i;
                pomY++;
                if(!this.walls[pomX][pomY]) // ce ni zida
                    if(found(pomX,pomY,pointer))
                        this.founded = true;
            }
            catch(ArrayIndexOutOfBoundsException napaka){

            }
            try{
                pomY = j;
                pomX = i;
                pomY--;
                if(!this.walls[pomX][pomY]) // ce ni zida
                    if(found(pomX,pomY,pointer))
                        this.founded = true;
            }
            catch(ArrayIndexOutOfBoundsException napaka){

            }
        }

    }
    
    boolean found(int x, int y, int pointer){
        if(this.rout[x][y] == -1){
            this.rout[x][y] = pointer; // z zadnim prepise -1 da dobim dolzino poti
            return true;
        }
        if((this.rout[x][y] == 0) || this.rout[x][y] >= this.pointer) // da ne grem nazaj 
            //treba se popraut ker zdej grem sam tja ker so 0le 
            //je popravln sam ni se testeran, ce ne dela ne dela tle
            this.rout[x][y] = pointer;
        return false;
    }
    
    void draw_routh(){
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                System.out.printf("%3d",this.rout[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public void setStartY(int x){
        this.rout[this.startY][0] = 0;
        this.rout[x][0] = 1;
        this.walls[x][0] = false;
        this.startY = x;
    }
    
    public void setStopY(int x){
        this.rout[this.stopY][this.height - 1] = 0;
        this.rout[x][this.height - 1] = -1;
        this.walls[x][this.height - 1] = false; 
        this.stopY = x;
    }
    void raise_walls(){
        this.walls = new boolean[width][height];
        this.rout = new int[width][height];
        int x = this.height - 1; // x je dolzina - 1, da dobim indekse tabele
        int y = this.width - 1;
        //this.rout[this.startY][0] = 1;
        //this.rout[this.stopY][x] = -1;
        this.setStartY(this.startY);
        this.setStopY(this.stopY);
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                this.walls[i][j] = false;
            }
        }
    }
    
    void draw_maze(){
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if(!this.walls[i][j])
                    System.out.printf("%3s", "O");
                if(this.walls[i][j])
                    System.out.printf("%3s", "X");
            }
            System.out.println();
            
        }
        System.out.println();
    }
    
    void set_walls(){

        this.walls[1][0] = true;
        this.walls[1][2] = true;
        this.walls[2][2] = true;
        this.walls[3][0] = true;
        this.walls[4][0] = false;
        this.walls[4][1] = false;
        this.walls[4][2] = true;
        this.walls[4][3] = true;
        //this.walls[2][1] = true;
        this.walls[3][0] = false;
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if(j>0 && i!=8){
                    this.walls[i][j] = true;
                    
                }
                
            }
            
        }
        this.walls[5][5] = false;
        this.walls[2][1] = false;
        //testni zidi, fiksni
//        this.walls[1][1] = false;
//        this.walls[1][2] = false;
//        this.walls[1][3] = false;
//        this.walls[1][4] = false;
//        this.walls[2][3] = false;
//        this.walls[2][4] = false;
//        this.walls[2][5] = false;
//        this.walls[2][6] = false;
//        this.walls[2][7] = false;
//        this.walls[2][8] = false;
//        this.walls[2][9] = false;
//        this.walls[2][10] = false;
//        this.walls[3][10] = false;
//        this.walls[4][10] = false;
//        this.walls[5][10] = false;
//        this.walls[6][10] = false;
//        this.walls[7][8] = false;
//        this.walls[6][8] = false;
//        this.walls[6][9] = false;
//        this.walls[7][10] = false;
//        this.walls[5][5] = false;
//        this.walls[7][10] = true;
//        this.walls[7][10] = false;

//            this.walls[2][1] = true;
//            this.walls[1][3] = true;
//            this.walls[3][3] = true;
//            this.walls[4][1] = true;
//            this.walls[4][2] = true;
//            this.walls[4][3] = true;
        this.setStartY(this.startY);
        this.setStopY(this.stopY);


    }
    
    void shortes_way(){
        int j = this.stopY;
        int i = this.height - 1;
        this.rout[j][i] = -1;
        this.pointer--;
        this.founded = false;
        while(!this.founded){
            for(int k = 0; k < this.width; k++){
                for (int z = 0; z < this.height; z++) {
                    if(this.rout[k][z] == -1){
                        j = k;
                        i = z;
                        this.step_back(j, i);
                    }
                }
            }
            this.pointer--;
        }
    }
    void draw_shortest_way(){
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if(this.rout[i][j] == -1)
                    System.out.printf("%3s", "|");
                else
                    if(this.walls[i][j])
                        System.out.printf("%3s", "X");
                    else
                        System.out.printf("%3s", "O");
            }
            System.out.println();
            
        }
        System.out.println();
    }
    
    void step_back(int j, int i){
        int pomX,pomY;
        pomY = j;
        pomX = i;
        pomX++;        
        try{
            if(this.rout[pomY][pomX] == pointer-1){
                if(this.rout[pomY][pomX] == 1)
                    this.founded = true;
                this.rout[pomY][pomX] = -1;
            }
        }
        catch(ArrayIndexOutOfBoundsException napaka){
            
        }
        pomX-=2;
        try{
            if(this.rout[pomY][pomX] == pointer-1){
                if(this.rout[pomY][pomX] == 1)
                    this.founded = true;
                this.rout[pomY][pomX] = -1;
            }
        }
        catch(ArrayIndexOutOfBoundsException napaka){
            
        }
        pomX++;
        pomY++;
        try{
            if(this.rout[pomY][pomX] == pointer-1){
                if(this.rout[pomY][pomX] == 1)
                    this.founded = true;
                this.rout[pomY][pomX] = -1;
            }
        }
        catch(ArrayIndexOutOfBoundsException napaka){
            
        }
        pomY-=2;
        try{
            if(this.rout[pomY][pomX] == pointer-1){
                if(this.rout[pomY][pomX] == 1)
                    this.founded = true;
                this.rout[pomY][pomX] = -1;
            }
        }
        catch(ArrayIndexOutOfBoundsException napaka){
            
        }
        
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    
    public int getStartY(){
        return this.startY;
    }
    
    public int getStopY(){
        return this.stopY;
    }
    
    public void setWidthHeight(int width, int height){
        this.width = width;
        this.height = height;
    }
    
    public int getLenght(){
        return this.length;
    }
    
    
    public Object[][] booleanToObject (boolean[][] tab){
        Object[][] res = new Object[this.width][this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if(tab[i][j])
                    res[i][j] = "X";
                if(!tab[i][j])
                    res[i][j] = "O";
                //res[i][j] = tab[i][j];
            }
        }
        return res;
    }
    
}
