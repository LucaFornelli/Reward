package rewards

class Award {

    Date awardDate
    String type
    Integer points
    static belongsTo = [customer: Customer]

    String toString () {
        "${type}: ${points}"
    }
    static constraints = {
        type(inList: ["Purchase", "Reward"])
    }
}
