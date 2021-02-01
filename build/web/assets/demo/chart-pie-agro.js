// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';


// Grafico de pizza de estados
var ctx = document.getElementById("pizzaestado");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["Agricultura", "Pecuaria"],
    datasets: [{
      data: [80, 20],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745', ],
    }],
  },
});

