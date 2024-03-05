import {Component, useContext, useEffect, useState} from "react";
import {CountryContext} from "../WealthManagement/wealthmanagement";
import { Chart } from 'primereact/chart';



function WealthDashboard(){
    const [chartData, setChartData] = useState({});
    const [chartOptions, setChartOptions] = useState({});
    const {countries,setCountries} = useContext(CountryContext);
    let countryData=[];
    let countryNames=[];
    countries?.forEach(x=>{
        countryNames.push(x.name);
        countryData.push(x.population);
    })

    console.log(countryData);

    useEffect(() => {
        const documentStyle = getComputedStyle(document.documentElement);
        const data = {
            labels: countryNames,
            datasets: [
                {
                    data: countryData,
                    backgroundColor: [
                        documentStyle.getPropertyValue('--blue-500'),
                        documentStyle.getPropertyValue('--yellow-500'),
                        documentStyle.getPropertyValue('--green-500')
                    ],
                    hoverBackgroundColor: [
                        documentStyle.getPropertyValue('--blue-400'),
                        documentStyle.getPropertyValue('--yellow-400'),
                        documentStyle.getPropertyValue('--green-400')
                    ]
                }
            ]
        }
        const options = {
            plugins: {
                legend: {
                    labels: {
                        usePointStyle: true
                    }
                }
            }
        };

        setChartData(data);
        setChartOptions(options);
    }, []);

        return(
            <div>
                <div className="card flex justify-content-center">
                    <Chart type="doughnut" data={chartData} options={chartOptions} className="w-full md:w-30rem" />
                </div>

            </div>
        )

}

export default WealthDashboard;
