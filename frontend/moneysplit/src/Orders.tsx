import * as React from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import Box from "@mui/material/Box";

// Generate Order Data
function createData(
  id: number,
  date: string,
  name: string,
  groupMembers: string,
  amount: number,
  paymentStatus: string,
) {
  return { id, date, name, groupMembers, amount, paymentStatus };
}

const rows = [
  createData(
    0,
    '16 Mar, 2019',
    'DR Trip',
    'Tupelo, MS',
    312.44,
      "PAID",
  ),
  createData(
    1,
    '16 Mar, 2019',
    'Waterloo Trip',
    'London, UK',
      312.44,
      "PAID",
  ),
  createData(
    3,
    '16 Mar, 2019',
    'Vancouver',
    'Gary, IN',
      312.44,
      "UNPAID",
  ),
  createData(
    4,
    '15 Mar, 2019',
    'Sameer Party',
    'Long Branch, NJ',
      312.44,
      "PAID",
  ),
];

function preventDefault(event: React.MouseEvent) {
  event.preventDefault();
}

export default function Orders() {
  return (
    <React.Fragment>
      <Title>Recent Splits</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Date</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>Group Members</TableCell>
            <TableCell>Amount</TableCell>
            <TableCell align="right">Status</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.id}>
              <TableCell>{row.date}</TableCell>
              <TableCell>{row.name}</TableCell>
              <TableCell>{row.groupMembers}</TableCell>
              <TableCell>{`$${row.amount}`}</TableCell>
              <TableCell align="right" style={{color: `${row.paymentStatus == "PAID" ? "#69da85": "red"}`}}>{`${row.paymentStatus}`}</TableCell>

            </TableRow>
          ))}
        </TableBody>
      </Table>
      <Link color="primary" href="#" onClick={preventDefault} sx={{ mt: 3 }}>
        See more orders
      </Link>
    </React.Fragment>
  );
}
