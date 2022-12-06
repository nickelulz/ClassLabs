format long G
years=[1,2,3,4,5,6,7,8,9,10,20]; % number of years after 2019
len=length(years);
% 2008-2015 production of diesel semi trucks
production=[3550.5,31954.5,57930;2300.9,20708.1,46715;3779.8,34018.2,44372;
7423.7,66813.3,71325;7436.1,66924.9,80558;7066.7,63600.3,67896;
10329.5,92965.5,74799;10799.5,97195.5,95769];
% 2008-2027 number of inoperable semi trucks
inoperable=[24491,66330.8,87598.9;220419,596977,788390.1;300899,666157,858732]’;
% 2019 production of diesel semitrucks
productionshort=10944.2;
productionregional=98497.8;
productionlong=101024;
% TRANSITION MATRICES
T=[1,0];
% Transition matrix for Markov chain describing the switch to electric
P1=[0.8,0.2;0.01,0.99]; % shorthaul
P2=[0.6,0.4;0.01,0.99]; % regionalhaul
P3=[0.4,0.6;0.01,0.99]; % longhaul
% Calculate the proportion of semitrucks that switch to electric
P={{},{},{}};
fori=1:(len-1)
P{1}{i}=T * P1ˆi; % short haul
P{2}{i}=T * P2ˆi; % regional haul
P{3}{i}=T * P3ˆi; % long haul
end
P{1}{11}=T * P1ˆ20;
P{2}{11}=T * P2ˆ20;
P{3}{11}=T * P3ˆ20;
% Predict the production of electric semi trucks in the next 8 years:
% Pred=PropN(1,1) * Prod(N)
predictions = zeros(8,3);% three types of semi truck

for i = 1 : 8
for j = 1 : 3
% number of electric semi trucks N years after 2019
predictions(i, j)=P{j}{i}(1,1) * production(i,j);
end
end

% Ensures that production is not below zero.
predictions(predictions¡0)=0;
% Calculate the number of short haul semi trucks after 5 years-I(1,1) * Prop5
short5=inoperable(1,1) * P{1}{5}
% short haul semi trucks after 10 years-I(1,2) * Prop10
short10=inoperable(1,2) * P{1}{10}
% short haul semi trucks after 20 years-I(1,3) * Prop20
short20=(inoperable(1,3)+sum(predictions(:,1))) * P{1}{11}
% regional haul semi trucks after 5 years-I(2,1) * Prop5
regional5=inoperable(2,1) * P{2}{5} 
% regional haul semi trucks after 10 years-I(2,2) * Prop10
regional10=inoperable(2,2) * P{2}{10}
% regional haul semi trucks after 20 years-I(2,3) * Prop20
regional20=(inoperable(2,3)+sum(predictions(:,2))) * P{2}{11}
% long haul semi trucks after 5 years-I(3,1) * Prop5
long5=inoperable(3,1) * P{3}{5}
% long haul semi trucks after 10 years-I(3,2) * Prop10
long10=inoperable(3,2) * P{3}{10}
% long haul semi trucks after 20 years-I(3,3) * Prop20
long20=(inoperable(3,3)+sum(predictions(:,3))) * P{3}{11}
% DiagramoftheMarkovchain
P=[0.8,0.2;
0.01,0.99];
% mc=dtmc(P);
figure;
% graphplot(mc);