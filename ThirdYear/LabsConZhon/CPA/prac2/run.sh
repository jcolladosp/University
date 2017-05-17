#!/bin/sh
#PBS -l nodes=1,walltime=00:05:00

#PBS -q cpa

#PBS -d .

echo "encaja e4 - pJ\n"
OMP_NUM_THREADS=2 ./encaja-e4-pJ
OMP_NUM_THREADS=4 ./encaja-e4-pJ
OMP_NUM_THREADS=8 ./encaja-e4-pJ
OMP_NUM_THREADS=16 ./encaja-e4-pJ
OMP_NUM_THREADS=32 ./encaja-e4-pJ


echo "encaja e4 - pX\n"
OMP_NUM_THREADS=2 ./encaja-e4-pX
OMP_NUM_THREADS=4 ./encaja-e4-pX
OMP_NUM_THREADS=8 ./encaja-e4-pX
OMP_NUM_THREADS=16 ./encaja-e4-pX
OMP_NUM_THREADS=32 ./encaja-e4-pX

