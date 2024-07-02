
export const company = (state) => state.company.company;
//export const Employee = (state) => state.employee.employee;
//export const Filterid = (state) => state.company.filterid;
//export const Relative = (state) => state.relative.relative;
// export const RemainngEmployee = createSelector(
//   Employee,
//   Filterid,
//   (employee, filter) => {
//     return employee.filter((el) => {
//       return el.idcompany.toString().includes(filter + "");
//     });
//   }
// );

// export const RemainngRelative = createSelector(
//   Relative,
//   RemainngEmployee,
//   (relative, employee) => {
//     return relative.filter((el) => {
//       return employee.some((el1) => {
//         return el.idEmployee.toString().includes(el1.id.toString());
//       });
//     });
//   }
// );
//  export const remaining = createSelector(product, filter, (product, filter) => {
//     return product.filter((el) => {
//         return el.type.includes(filter);
//     });
// });
