JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
ORGDIR=org/jfugue/player
CLASSPATH=-cp .:./$(ORGDIR):jfugue-5.0.9.jar
.java.class:
	$(JC) $(JFLAGS) $(CLASSPATH) $*.java

CLASSES = \
        Member.java \
        Orchestra.java \
        Instrument.java \
        Cello.java \
        Contrabass.java \
        Viola.java \
        Violin.java \
        JFugueMusic.java \
        $(ORGDIR)/Player.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
