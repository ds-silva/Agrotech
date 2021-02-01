// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';


// Grafico de pizza de estados
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["Recife", "Paraná", "Paraíba", "Mato Grosso do Sul", "Rio de Janeiro"],
    datasets: [{
      data: [15, 10, 15, 30, 30],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745', ],
    }],
  },
});

