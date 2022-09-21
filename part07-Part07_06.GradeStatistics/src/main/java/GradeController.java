import java.util.ArrayList;

public class GradeController {
    ArrayList<Integer> grades;

    public GradeController() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grades.add(grade);
        }
    }

    public double average() {
        int sum = 0;
        for (int grade : this.grades) {
            sum += grade;
        }
        return (double) sum / this.grades.size();
    }

    public double passAverage() {
        int sum = 0;
        int count = 0;
        for (int grade : this.grades) {
            if (grade >= 50) {
                sum += grade;
                count++;
            }
        }
        return (double) sum / count;
    }

    public double passPercentage() {
        int count = 0;
        for (int grade : this.grades) {
            if (grade >= 50) {
                count++;
            }
        }
        return (double) count / this.grades.size()*100.0;
    }

    public int[] gradeDistribution(){
        int[] distribution = new int[6];
        for (int grade : this.grades) {
            if (grade < 50) {
                distribution[0]++;
            } else if (grade < 60) {
                distribution[1]++;
            } else if (grade < 70) {
                distribution[2]++;
            } else if (grade < 80) {
                distribution[3]++;
            } else if (grade < 90) {
                distribution[4]++;
            } else {
                distribution[5]++;
            }
        }

        return distribution;
    }

}
