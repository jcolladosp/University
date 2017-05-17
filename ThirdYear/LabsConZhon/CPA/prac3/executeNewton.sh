#!/bin/sh
#PBS -l nodes=4,walltime=00:10:00
#PBS -q cpa
#PBS -d .

mpiexec ./newton -c4 -r0.01 -x0.1 -y0.2 -p25

