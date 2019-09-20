x1 <- <score>
x2 <- <time>
x3 <- <pourc>

path <- <path>

label <- <label>
nbstrat <- <nbstrat>

colors = c("blue","pink","green","mediumvioletred", "red","lightseagreen","chocolate1", "darkolivegreen4")

names(x3) = label;
png(paste0(path , "/PourcentageparStrategie.png"), width = 1000, height = 1000)

bp <- barplot(x3,ylab="Pourcentage", main = "Pourcentage de remplissage des caches par strategie", ylim = c(0,max(x3)*1.1),
        col = colors)
text(bp, y=x3, labels=paste(x3,'%'), pos = 3)


names(x1) = label;
dev.off()
png(paste0(path , "/ScoreparStrategie.png"), width = 1000, height = 1000)

bp <- barplot(x1,ylab="Score", main = "Score par strategie", ylim = c(0,max(x1)*1.2),
        col = colors)
text(bp, y=x1, labels=x1, pos = 3)

names(x2) = label;
dev.off()
png(paste0(path , "/TempsparStrategie.png"), width = 1000, height = 1000)

bp <- barplot(x2, ylab="temps (en s)", main = "Temps par strategie", ylim = c(0,max(x2)*1.2),
        col = colors)
text(bp, y=x2, labels=round(x2,digits = 9), pos = 3)

dev.off()
png(paste0(path , "/ComparaisondesStrategies.png"), width = 1000, height = 1000)
plot(x2,x1, xlab = "Temps", ylab = "Score", cex=3, pch = 18,
     col = colors, ylim = c(0,max(x1)*1.2), main = "Comparaison des strategies")

legend("bottomright", label, cex=0.8,
       fill=colors)

dev.off()