import sys
import os

if len(sys.argv) < 3:
    print "Input and output filename required"
    exit(-1)

if not os.path.isfile(sys.argv[1]):
    print "unable to open:", sys.argv[1]
    exit(-1)

print "fetching from:", sys.argv[1], "..."

in_p = sys.argv[1]
out_p = sys.argv[2]


with open(in_p,'r') as reader, open(out_p,'w') as writer:

    lines = reader.readlines()
    result = []
    sim = False
    graph = False
    move = False
    for x in lines:
        result.append(x.split())
    reader.close()
    
    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
    writer.write("<!DOCTYPE simulation SYSTEM \"simulation.dtd\">\n")
    
    length = len(result) 
    i = 0
    aux = "1"
    print "writing to:", sys.argv[1], "..."

    while i < length:            
        if result[i][0] == 'simulation':
            if len(result[i]) >= 4:
                writer.write("<simulation finalinst=\"" + result[i][1] + "\" antcolsize=\"" + result[i][2]+ "\" plevel=\"" + result[i][3] + "\">\n")
                sim = True
            else:
                print "Insufficient Simulation parameters"
                exit(-1)

        elif result[i][0] == 'graph':
            if not sim:
                print "Simulation parameters not read"
                exit(-1)
            if len(result[i]) >= 3:
                writer.write("  <graph nbnodes=\"" + result[i][1] + "\" nestnode=\"" + result[i][2] + "\">\n")
                writer.write("      <node nodeidx=\"" + "1" + "\">\n")
                graph = True
            else:
                print "Insufficient Graph parameters"
                exit(-1)
            
        elif result[i][0] == 'move':
            if len(result[i]) >= 4:
                writer.write("      </node>\n")
                writer.write("  </graph>\n")
                writer.write("  <events>\n")
                writer.write("          <move alpha=\"" + result[i][1] + "\" beta=\"" + result[i][2] + "\" delta=\"" + result[i][3] + "\"/>\n")
                move = True
            else:
                print "Insufficient event move parameters"
                exit(-1)

        elif result[i][0] == 'evaporation':
            if not move:
                print "move event parameters not read"
                exit(-1)
            if len(result[i]) >= 3:
                writer.write("        <evaporation eta=\"" + result[i][1] + "\" rho=\"" + result[i][2] + "\"/>\n")
                writer.write("    </events>\n")
                writer.write("</simulation>\n")
            else:
                print "Insufficient event evaporation parameters"
                exit(-1)
        
        elif result[i][0] == aux:
            if len(result[i]) < 3:
                writer.write("          <weight targetnode=\"" + result[i][1] + "\">" + "1" + "</weight>\n")
            else:
                writer.write("          <weight targetnode=\"" + result[i][1] + "\">" + result[i][2]  + "</weight>\n")

        else:
            if not graph:
                print "Graph parameters not read"
                exit(-1)
            aux = result[i][0]
            writer.write("      </node>\n")
            writer.write("      <node nodeidx=\"" + result[i][0] + "\">\n")
            if len(result[i]) < 3:
                writer.write("          <weight targetnode=\"" + result[i][1] + "\">" + "1" + "</weight>\n")
            else:
                writer.write("          <weight targetnode=\"" + result[i][1] + "\">" + result[i][2]  + "</weight>\n")
        i += 1

    writer.close()
    exit(0)
        

